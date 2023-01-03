/**
 * @author GK
 *
 */
package solutions.pratnya.erp;


import org.jdbi.v3.core.Jdbi;

import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.jdbi3.JdbiFactory;
import solutions.pratnya.erp.resources.ErpIndividual;
import solutions.pratnya.erp.resources.ErpResource;

public class ErpApplication extends Application<ErpConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ErpApplication().run(args);
    }

    @Override
    public String getName() {
        return "erp";
    }

    @Override
    public void initialize(final Bootstrap<ErpConfiguration> bootstrap) {
    	bootstrap.addBundle(new AssetsBundle("/assets/", "/client"));
    }

    @Override
    public void run(final ErpConfiguration configuration,
                    final Environment environment) {
    	final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mariadb");
    	environment.jersey().register(new ErpResource());
    	environment.jersey().register(new ErpIndividual(jdbi));
    }

}
