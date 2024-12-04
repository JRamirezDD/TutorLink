BEGIN

   IF NOT EXISTS (SELECT 1 FROM pg_namespace WHERE nspname = 'cross_domain_interactions_schema') THEN

      CREATE SCHEMA cross_domain_interactions_schema;

   END IF;

END;