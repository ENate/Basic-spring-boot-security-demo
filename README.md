### A Spring boot and security Example

This repository contains a spring boot 3.0+ and spring security 6.0+. 
The following tech stack is reuired to run the example:

### Tech Stack

- Java/Jdk 17+
- Spring boot
- maven ( or gradle with adaptations)
- Spring Security
In order to run the application, clone the repo as follows:

``` git clone <repo_name> ``` and run using one of your favorite IDEs.

### Running the application

Either run from the command line (linux is used in this repository but other operating systems are also similar) or using your chosen integrated development environment (IDE). 
If local, open the local host (on the browser) using on port ``` http://localhost:8088.``` Enter the username:  ```user``` and password: ```password``` to login. The aim of this project is to demonstrate the recent updates for spring security 6.0+ flow via filter chains.

We use the default spring security implementation for form login and ```noop``` pass word encryption mechanism. 
However, this should NEVER be used in production and used here for demonstration purposes only! 
More details from the [spring security documentation here.](https://spring.io/projects/spring-security)


