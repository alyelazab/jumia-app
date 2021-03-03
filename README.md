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

- Then Go to http://127.0.0.1:9090/

*Disclaimer* :

The first time the project goes up it takes around 10 minutes as docker caches all the maven dependencies. 
The next time it comes up, it should be instantaneous.

For the front-end, you should expect to see this:


![Screen Shot 2021-03-03 at 2 55 01 PM](https://user-images.githubusercontent.com/59670782/109809654-3dfa7d00-7c31-11eb-9662-1a8246fde8c0.png)

You can sort and filter the table based on the Name, Number, Country Code, Country and State fields. To sort the table, all you have to do is click
on the desired sorted field. To filter a field, click on the the sidebar at the far right end of any of the fields. You can then choose how you want
to filter the field. The following screenshots are a demonstration of both a sort on the Name field, and a filter on the Country field:


![Screen Shot 2021-03-03 at 3 06 14 PM](https://user-images.githubusercontent.com/59670782/109810767-9da55800-7c32-11eb-8a97-169e909ffefd.png)


![Screen Shot 2021-03-03 at 3 15 15 PM](https://user-images.githubusercontent.com/59670782/109811284-494ea800-7c33-11eb-8a0c-5ff9175319ec.png)
