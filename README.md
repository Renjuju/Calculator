# Socket-Server Architecture Styled MVC Calculator

##Features
* Implemented using MVC, Visitor, and Composite patterns
* Java Swing
* Usuable UI

##Installation
* Any java idea
* Compile and run

##How to run?
* Run MVCCalculator
```java
public class MVCCalculator {
        public static void main(String[] args) {
                CalculatorController controller = new CalculatorController();
                controller.start();
                Thread serverThread = new Thread() {
                        public void run() {
                                CalculatorServer server = new CalculatorServer(5000);
                                try {
                                        server.start();
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        }
                };

                Thread clientThread = new Thread() {
                        public void run() {
                                CalculatorClient client = new CalculatorClient("localhost", 5000);
                                client.start();
                                try {
                                        client.readResponse();
                                } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                }
                        }
                };

                serverThread.start();
                clientThread.start();
        }
}
```
##Why?
Systems Architecture homework assignment
