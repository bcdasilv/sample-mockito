# sample-mockito
An example of unit testing with JUnit and Mockito.

The src/manualmock package contains test doubles created without using Mockito. These are stubed versions of the email and print services.

The src/withmockito package contains test doubles created using Mockito. These doubles are mocks of the email and print services.

### Dependencies: [JUnit](https://junit.org/) and [Mockito](https://site.mockito.org/)
To compile and execute the test cases you need JUnit and Mockito in the classpath (properly installed).
There are multiple ways of doing it (e.g., Maven, Graddle, local lib import, etc.)
