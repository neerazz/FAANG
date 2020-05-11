#Tips for System Design

- Read the question properly? **[2-3 mins]**
    > Understand the question.
-  Requirement gathering? (You can ask as many question as you want.) **[4-5 mins]**
    > Required details ex: Design a twitter like application.
    > 
    > - Can a user follow another user?
    > - Can a user follow a group?
    > - What should happen when a followed user\group has any event.
    > - Who can post a tweet?
    > - Is there any max length for a tweet?
    > - Can a user post a link or video?
    > - How to build

-  Back of envelop calculations: **(Check if this is needed or not)**
    > - If you must build any application there will be some backend logic or calculation that needs to happen. Like Will this application be across the globe, if so, a user needs to be checked with all countries user id DB to populate a user id.
    > - What is the scale and user base?
    > - What will be the active users?

-  Service API design: **[5-10 mins]**
    > - Suppose you are asked to design an online ticketing application where the users can buy tickets of movies on cinema halls in a city online. You can think of building a Restful api that
    > - Can server the various clients like website, mobile apps, ipad or other tablet apps, or even voice assistants etc.
    > - Some of the features or methods that you can build in the API could be
    >> #### buyTickets(apiKey, user, movie, seat, cinemaHall) : This can be a method to purchase a ticket for a movie online.
    >> - apiKey : This could be a unique key given to each user who accesses your api. This will help in stopping users from throttling your website by abusive usage.
    >> - user: an object containing information for the user as needed by this method e.g. userld, payment information.
    >> - movie: contains information about the movie like movield
    >> - seat : seat information inside a cinema hall.
    >> - cinemaHall : information about the cinema hall, we can keep a unique cinema hall id in city (we can have a city id cinema id combo as a key too)
    >
    >> #### searchMovies(apiKey, srchQry) : Method to search for movies currently run. This can be a &#39;contained&#39; search or &#39;like&#39; query.
    >> • apiKey : This could bea unique key given to each user who accesses your api. This will help in stopping users from throttling your website by abusive usage.
    >> 
    >> • srchQry : String or text containing part of a movie name.
    >> 

- Database Design: (Scalability is an iterative process) **[4-5 mins]**
    > ##### Draw an ER diagram (Like below)
    > ![Sample](https://d2slcw3kip6qmk.cloudfront.net/marketing/pages/chart/examples/databaseerdiagram.svg)

- High level design: **[3-5 mins]**
    > Consider drowing a end-to-end flow. (Like below)
    ![Sample](https://camo.githubusercontent.com/2e0371e591b8311e36f5f5fa6ae18711f252b1f8/687474703a2f2f692e696d6775722e636f6d2f424b73426e6d472e706e67)
- Low level Design: (Core business logic) **[15-20 mins]**
    > 
    > **Suppose you are designing the 'Feed' for a website like LinkedIn.** You know that this is the feature of the App. In this case in the low-level design we can mention how we can go about building this entire feed. Some steps and key points can be:
    > 
    > - In the requirements itself we can clear that like 'What kind of feed we want, precomputed or generated at runtime', 'how many posts can be there in the feed', 'can we store the feed in the webcache','what happens when a user follows hundreds or more number of other users'
    > - To design we can mention that for most users the feeds can be pulled from the cache, we can take an average number of ballpark users the user follows and estimate the feed and its size..
    > - We can precompute the feeds for a user and store in cache. For faster updates the batch job can run frequently and parallelly on different partitions of the user data.
    > - For celebrities kind of users where they have millions on followers the followers can get their feed post by push based mechanism, using stuff like long polling and getting data from the high scale users. 
    > - We can have a set of services that pull this read only feed from the cache or if it is not in cache for low power users it can be built at runtime too. 


-  Scalability and other issues: 
    > 
    > These are topics like load balancer, caching, partitioning, security etc.  
     **If you have any flaws in, you design feel free to mention that.** 