package pl.mfalkowski.appenginefirstapp.api.tasks.wykop

import spock.lang.Specification

import javax.ws.rs.client.ClientBuilder

class WykopClientTest extends Specification {

    def client = ClientBuilder.newClient()
    def properties = getWykopProperties()
    def wykopClient = new WykopClient(client, properties)

    def "should"() {
        when:
        def response = wykopClient.getLatestEntriesForTag("spacex")

        then:
        1 == 2
    }


    def getWykopProperties() {
        Properties properties = new Properties()
        InputStream propertiesFile = getClass().getResourceAsStream("/test.properties");
        if (propertiesFile == null) {
            throw new IllegalStateException("cannot find test.properties file in your classpath")
        }
        properties.load(propertiesFile)
        propertiesFile.close()

        return WykopProperties.builder()
            .withWykopAppKey(properties.getProperty("wykopAppKey"))
            .build()
    }

}
