# Stage 1: Build Flutter application
# Use a Dart image as the base for building
FROM fischerscode/flutter-sudo:stable as build

# Set working directory
WORKDIR /app

# Set working directory
WORKDIR /app

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

# Stage 2: Serve the Flutter build with NGINX
FROM nginx:stable-alpine

# Copy the build output from the build stage
COPY --from=build /app/build/web /usr/share/nginx/html

# Expose the default NGINX HTTP port
EXPOSE 80

# Start NGINX server
CMD ["nginx", "-g", "daemon off;"]
