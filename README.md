# Partify

--------------------------
The Idea
--------------------------

partify is a collaborative playlist 

there is one host (server) and there are clients who want to contribute to the playlist (i.e. add songs) will send the URL of the desired song over through the client-server. 

from here, all the clients who are connected are able to vote no if they do not like the recently added song.

the host has the veto power, being able to say yes or no

------------------------------
TODO
------------------------------
1. create a client-server architect (done)
2. modify the client-server architect to have the correct GUI
3. use JSoup to identify which song which song needs to be sent over and to ID the song URL
4. from the server side, retreive the URL given from one of the clients
5. from the server side, use JSoup to play the song
6. configure the voting system
...
??? port this idea over to Android/Mobile where it would be most useful and applicable
