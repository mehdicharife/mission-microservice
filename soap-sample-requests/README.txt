To test sending one of the request messages in this directory simply run
the following curl command with replacing <filename> with the one corresponding
to the request you want to send:

curl --header "content-type: text/xml" -d @<filename> http://localhost:8080/ws