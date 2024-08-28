# Jobs Backend

## Description

The Jobs Backend project is a comprehensive backend service designed to manage job listings, company information, and
related data for a job board application. It leverages Spring Boot for rapid development and integration, and includes
various features to ensure robust and scalable performance.

### Key Features:

* **Company Management:** Create, read, update, and delete company information.
* **Job Listings:** Manage job offers, including details and statuses.
* **API Documentation:** Automatically generated OpenAPI documentation for easy API consumption.
* **Security:** Integration with HashiCorp Vault for secure management of sensitive data.
* **Configuration Management:** Centralized configuration using Spring Cloud Config.
* **Service Discovery:** Integration with Eureka for service registration and discovery.
* **Database Integration:** Uses PostgreSQL for data persistence.
* **Testing:** Comprehensive testing setup with JUnit and Mockito.
* **Continuous Integration:** Built-in CI/CD pipeline using GitLab CI/CD.
* **Docker Support:** Dockerfile included for containerization and easy deployment.</br>
  This project is designed to be easily extendable and maintainable, providing a solid foundation for building a job
  board application.

## Badges

On some READMEs, you may see small images that convey metadata, such as whether or not all the tests are passing for the
project. You can use Shields to add some to your README. Many services also have instructions for adding a badge.

## Visuals

Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see
GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation

Within a particular ecosystem, there may be a common way of installing things, such as using Yarn, NuGet, or Homebrew.
However, consider the possibility that whoever is reading your README is a novice and would like more guidance. Listing
specific steps helps remove ambiguity and gets people to using your project as quickly as possible. If it only runs in a
specific context like a particular programming language version or operating system or has dependencies that have to be
installed manually, also add a Requirements subsection.

## SSL Setup

Require certificates. To add certificates to the JVM trust, you need to follow the instructions provided below:<br>  
`keytool -import -alias [ALIAS_CERTIFICATE] -keystore "[JAVA_PATH]\lib\security\cacerts" -file [CERTIFICATE_PATH]`

## Dependencies

| Name                    | Version    |
|-------------------------|------------|
| PostgreSQL              | 42.5.1     |
| HashiCorp Vault         | ----       |
| PRX Stage Folder Config | ----       |
| PRX Discovery Service   | 0.0.2-2023 |
| PRX Config Server       | 0.0.2-2023 |
| PRX Commons             | 0.0.2-2023 |
| Spring Boot             | 6.1.11     |
| Spring Boot             | 3.3.2      |
| Spring Cloud            | 4.1.3      |
| JUnit                   | 5.9.3      |
| Mockito                 | 5.2.0      |

## Environment variables

| Name                                    | Value          | Description                            |
|-----------------------------------------|----------------|----------------------------------------|
| SPRING_BOOT_PROFILE_ACTIVE              | default \| dev | The active Spring Boot profile         |
| SPRING_BOOT_CLOUD_BOOTSTRAP_ENABLED     | Boolean        |                                        |
| SPRING_BOOT_PROFILE_ACTIVE              | String         |
| SPRING_CLOUD_CONFIG_LABEL               | String         | Spring Cloud Config label              |
| JMX_DEFAULT_DOMAIN                      | String         | JMX default domain                     |
| CONFIG_SERVER_URL                       | String         | The URL for the config server          |
| VAULT_SERVER_URL                        | String         |                                        |
| VAULT_TOKEN                             | String         |                                        |
| POSTGRES_USERNAME                       | String         | The username for the Postgres database |
| POSTGRES_PASSWORD                       | String         | The password for the Postgres database |
| POSTGRES_HOST                           | String         | The host for the Postgres database     |
| POSTGRES_PORT                           | Integer        | The port for the Postgres database     |
| POSTGRES_DATABASE                       | String         | The name of the Postgres database      |
| EUREKA_HOSTNAME                         | String         | The hostname for Eureka                | 
| EUREKA_URL                              | String         | The URL for Eureka                     |
| EUREKA_PORT                             | Integer        | The port for Eureka                    |
| EUREKA_DEFAULT_ZONE                     | String         | The default zone for Eureka            |
| EUREKA_STATUS_PAGE_URL_PATH             | String         | The status page URL path for Eureka    |
| EUREKA_HEALTH_CHECK_URL_PATH            | String         | The health check URL path for Eureka   |
| EUREKA_HOME_PAGE_URL_PATH               | String         | The home page URL path for Eureka      |
| SSL_JKS_CONFIG_SERVER_KEY_ALIAS         | String         | The alias for the key in the keystore  |
| SSL_JKS_CONFIG_SERVER_KEYSTORE_LOCATION | String         | The location of the keystore           |
| SSL_JKS_CONFIG_SERVER_KEYSTORE_PASSWORD | String         | The password for the keystore          |
| SSL_JKS_CONFIG_SERVER_KEYSTORE_TYPE     | String         | The type of the keystore               |

## Docker Setup

### Docker Hub

* Build the image:\
  `docker build -t lamata/job-backend-api .`<br>
* Pull the image from the Registry container<br>
  `docker pull lamata/job-backend-api -u [USER_REGISTRY] -p [TOKEN]`## Usage<br>
* Push the image in the Docker hub<br>
  `docker push lamata/job-backend-api -u [USER_REGISTRY] -p [TOKEN]`

### Gitlab Container

* Login (using token)<br>
  `docker login registry.gitlab.com`
* Build image<br>
  `docker build -t registry.gitlab.com/jobs-board/jobs-backend .`<br>
* Pull the image from GitLab Container Registry<br>
  `docker pull registry.gitlab.com/jobs-board/jobs-backend`<br>
* Push the image to GitLab Container Registry<br>
  `docker push registry.gitlab.com/jobs-board/jobs-backend`

## Support

Tell people where they can go to for help. It can be any combination of an issue tracker, a chat room, an email address,
etc.

## Roadmap

If you have ideas for releases in the future, it is a good idea to list them in the README.

## Contributing

State if you are open to contributions and what your requirements are for accepting them.

For people who want to make changes to your project, it's helpful to have some documentation on how to get started.
Perhaps there is a script that they should run or some environment variables that they need to set. Make these steps
explicit. These instructions could also be useful to your future self.

You can also document commands to lint the code or run tests. These steps help to ensure high code quality and reduce
the likelihood that the changes inadvertently break something. Having instructions for running tests is especially
helpful if it requires external setup, such as starting a Selenium server for testing in a browser.

## Authors and acknowledgment

Luis Antonio Mata</br>
Contact: Luis Mata<luis.antonio.mata@gmail.com></br>
Show your appreciation to those who have contributed to the project.

## License

For open source projects, say how it is licensed.

## Project status

If you have run out of energy or time for your project, put a note at the top of the README saying that development has
slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or
owner, allowing your project to keep going. You can also make an explicit request for maintainers.

