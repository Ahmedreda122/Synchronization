# Problem Definition:<br>
It is required to simulate a limited number of devices connected to a router’s Wi-Fi
using Java threading and semaphore. Routers can be designed to limit the number of
open connections. For example, a Router may wish to have only N connections at any
point in time. As soon as N connections are made, the Router will not accept other
incoming connections until an existing connection is released. Explain how
semaphores can be used by a Router to limit the number of concurrent connections.<br>
### The following rules should be applied: <br>
• The Wi-Fi number of connected devices is initially empty.<br>
• If a client is logged in (print a message that a client has logged in) and if it can
be served (means that it can reach the internet), then the client should<br>
### perform the following activities: <br>
◆ Connect<br>
◆ Perform online activity<br>
◆ Log out<br>
Note: these actions will be represented by printed messages, such that there is a
random waiting time between the printed messages when a client connects, do
some online activities and logged out.<br>
• If a client arrives and all connections are occupied, it must wait until one of
the currently available clients finish his service and leave.<br>
• After a client finishes his service, he leaves and one of the waiting clients (if
exist) will connect to the internet.<br>
# Solution Design:<br>
## Your program must contain the following classes:<br>
1. Router Class: This class contains a list of connections and methods to occupy a
connection and release a connection.<br>
2. Semaphore Class: As given in the synchronization lab (Check Lab 3).<br>
3. Device Class: Represent different devices (threads) that can be connected to the
router<br>
Each device has its own name (i.e. C1) and type (i.e. mobile, pc, tablet...) and it may
perform three activities: connect, perform online activity and disconnect/logout.<br>
4. Network Class: This class contains the main method in which the user is asked
for two inputs:<br>
● N: max number of connections a router can accept<br>
● TC: total number of devices that wish to connect).<br>
● TC lines that contain the name of each device, and its Type.<br>
# Program Output:<br>
You will print the output logs in a file, which simulates the execution order of the
devices threads and the printed messages of each device
