Camel Router Project for Blueprint (OSGi)
=========================================

To build this project use

    mvn install

To run the project you can execute the following Maven goal

    mvn camel-karaf:run

To deploy the project in OSGi. For example using Apache ServiceMix
or Apache Karaf. You can run the following command from its shell:

    osgi:install -s mvn:com.hotRod/hotRod/1.0-SNAPSHOT

For more help see the Apache Camel documentation

    http://camel.apache.org/

