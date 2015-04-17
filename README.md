Project Summary

Aim:
The Aim of this assignment is to explore the Java EE service layer components of an enterprise application, 
integrate the JPA domain model with the service layer, and also introduce security to the application.

I am using Maven Web Application project to implement the above functionalities using the 
Server: Glassfish application server
Framework: JavaEE(@Stateless EJB) for the service layer components
The MP3 domain model is implemented as the persistence layer using the EclipseLink JPA implementation and NetBeans IDE.

EJB(Enterprise Java Beans) are defined as server-side components whose function is to encapsulate the java code for business logic to perform transaction management and provide security to the application.

Session EJBs: It is defined as a nonpersistent object which means that the lifetime of the object is short. Lifetime of the session EJBs are measured by the duration of the interaction between client and the EJB. Generally when EJBs are created by the client, client invokes methods, removes it. If the client doesn’t destroy it, it will be removed by the EJB container due to inactivity over certain period of time. Session EJBs are further divided into two types:
•	Stateful session EJB: The EJB is shared among various users.
•	Stateless session EJB: The EJB is created only for a particular user only.

Stateless EJBs: The Stateless beans are used in an application through the annotation, @ Stateless. This session bean holds no state conversed between the methods, the client can use any of the instances as it is shared amongst various clients. It is generally useful to handle the tasks which are performed using a single method call.

The security is introducted to the application project using the Java EE security that incorporates both authentication and authorization.
The Mp4 project consists of following modules:
a)Domain model: It contains the Entity Tables:
1)      Customers
2)      Ordered
3)      Order_Details
4)      Manufacturers
5)      Categories
6)      Products

b)Domain Security model: It contains the entity tables:
1)User(sec_user)
It has the attributes: USERNAME and PASSWORD which is hashed by using the digestUtil method for the security purposes.
I have created following users:
'liki'
'jee' which have to access to enter the product portal, has access to the information provided in the product portal.
and 'fan' which has the access to enter the customer portal, and to the information provided in the customer portal. 
2)Group(sec_group)
It has the following attributes:
GROUPNAME and GROUPDESC
It has two groups 1) Customer: User 'fan' is associated with this group.
2) Manufacturer: User 'liki' and 'jee' are associated with this group.
These are also the role names assigned to the users.
These entity tables are introduced in order to add security to the application project that is the persistent objects.
A new jdbcRealm Security Realm is created in Glassfish with the User(Sec_user) and Group(sec_group) tables.
Two or more security roles are defined for this application in web.xml.
The roles are mapped to users and groups using glassfish-web.xml.

c)Web model:
It contains the following portals each of which extends the HttpServlet class:
1)CustomerPortalTestServlet
It contains the web servlet with the URL patterns {'/customerPortal/','/customerPortal'}, once we login with the role name 'customer' with the user name 'fan' and password ' abc123' , and submit the login form , the form action matches the URL of servlet from @webServlet.One can find the information about the customer. And the logout link connects to the LogoutServlet.

2)LogoutServlet
It contains the web servlet with the URL patterns {'/Logout'}, It helps us to logout of the current page and allows the user to either login as a customer or as a manufacturer.

3)ProductPortalTestServlet
It contains the web servlet with the URL patterns {'/productPortal/','/productPortal'}, once we login with role name 'manufacturer' through the user name 'fan' and password ' abc123' , and submit the login form , the form action matches the URL of servlet from @webServlet.One can find the information about the manufacturer, products and categories. And the logout link connects to the LogoutServlet.
 
d)Service model:
It consists of the following services:
1)       AbstractService
2)      CustomerService
3)      ProductService
4)      ManufacturerService
5)      CategoryService
6)      UserService
7)      GroupService
8)      Databasepopulator

AbstractService implements the CRUD(Create, Read, Update, Delete) operations. Every service class extends it.
We need to set the relationships before passing it to the service layers.
Additional feature findByUserName() is added onto the service classes and implemented as well. 

The relationships are defined among the entities and data is populated in the class 'Databasepopulator'.
The relationships are as follows:
1) Category----- ManyToOne---------> Product
2) Product----- OneToMany---------> Category
3) Customer----- OneToOne---------> sec_user
4) sec_user------OneToOne----------->Customer
5) Ordered------ManyToOne-------->Customer
6) Customer------OneToMany--------->Ordered
7) Order_Details----OneToOne------->Ordered
8) Category----- ManyToMany--------->Manufacturer
9) Manufacturer----- ManyToOne---------> Product
10) Product----- OneToMany--------->Manufacturer
11) Product----- OneToMany---------> Manufacturer
12) Manufacturer----- OneToOne---------> sec_user
13) sec_user------OneToOne----------->Manufacturer

There are following joined tables:
Category_manufacturer
manufacturer_category
product_manufacturer
sec_user_groups

Screenshots:
1) Login(Index page)
2) Logging as a customer with the following credentials
3) Logging as a manufacturer with the following credentials
4) Logout
5) Logging with wrong credentials



Deployment instructions:
1)Unzip the MP4 zip folder to find the application project llokesh_mp4_ejb.
2)Import the project into the netbeansIDE.
3)Create a database itmd4515, and create a MySQL user named as itmd4515 with password itmd4515 and provide full rights to the user.
4) The database connection with the IDE is done via the JPA tools. The above given user name and password must be mentioned in the persistence unit of the project.
5) Once you run the project, make sure that the tables are created and the respective data is populated in the database 'itmd4515' in the MySQL workbench. we can either log in as a customer or as a manufacturer. As a customer we need to use the credentials: username 'fan'
             password: 'abc123'
6) As a manufacturer we need to use the following credentials:
             username: 'liki'
             password: 'abc123'
7) Click on the logout link to logout of the page and login link to login back as either a customer or a manufacturer.
8) Entering the wrong credentials will direct you to the error page.



