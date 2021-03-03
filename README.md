# jumia-app
Jumia customer's phone validation application

To build up the project using docker, you have two options.

Option 1:

In directory jumia-app run: docker-compose up

Go to http://127.0.0.1:9090/

Option 2:

In directory jumia-app-server run: 
docker build -t jumia-app/server .
docker run -p 8080:8080 jumia-app/server

In directory jumia-app-client run:
docker build -t jumia-app/client .
docker run -p 9090:80 jumia-app/client

Go to http://127.0.0.1:9090/

*Disclaimer* 
The first time the project goes up it takes around 10 minutes as docker caches all the maven dependencies. 
The next time it comes up, it should be instantaneous.

For the front-end, you should expect to see this:
