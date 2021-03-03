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
![Screen Shot 2021-03-03 at 2 55 01 PM](https://user-images.githubusercontent.com/59670782/109809654-3dfa7d00-7c31-11eb-9662-1a8246fde8c0.png)
