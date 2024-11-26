# Stage 1: Build Flutter application
# Use a Dart image as the base for building
FROM fischerscode/flutter-sudo:stable as build

# Set working directory
WORKDIR /app
RUN ls -al /app 

# Copy project files
COPY pubspec.yaml pubspec.lock ./
COPY lib ./lib
COPY assets ./assets 
COPY web ./web

# fix folder permissions (can't read pubspec.lock otherwise)
USER root
RUN chown -R flutter: /app
USER flutter


# Enable Flutter web support
RUN flutter doctor -v && flutter config --enable-web

# Clean the project (to avoid conflicts)
RUN flutter clean

# Ensure dependencies are resolved
RUN flutter pub get

# Build the Flutter project for web
RUN flutter build web --release

# Stage 2: Serve Flutter application using NGINX
FROM nginx:stable-alpine

# Copy Flutter build to NGINX
COPY --from=build /app/build/web /usr/share/nginx/html

# Copy custom NGINX configuration
COPY nginx.conf /etc/nginx/nginx.conf

# Expose the default NGINX HTTP port
EXPOSE 80

# Start NGINX server
CMD ["nginx", "-g", "daemon off;"]
