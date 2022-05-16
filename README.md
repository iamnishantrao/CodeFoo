# Spring Boot Backend API
A backend project which reads the content of the [CSV sample file](https://media.ignimgs.com/code-foo/2020/files/codefoobackend_cfgames.csv), 
stores them into a  SQL database and then this data can be accessed in different ways using endpoints provided.

## Storing of data in SQL Database
To store the data in SQL database, the schema contains the following tables:
1. **MediaDetails Table**: This is the main table and contain most of the information from the CSV for each object, except for the list variables which can have multiple values.
2. **Regions Table**: Stores regions data for each media stored in MediaDetails table using one-to-many relationship.
3. **CreatedBy Table**: Stores created by data for each media stored in MediaDetails table using one-to-many relationship.
4. **Franchises Table**: Stores franchises data for each media stored in MediaDetails table using one-to-many relationship.
5. **Genres Table**: Stores genres data for each media stored in MediaDetails table using one-to-many relationship.
6. **PublishedBy Table**: Stores published by data for each media stored in MediaDetails table using one-to-many relationship.

## API Endpoints
- **/upload** - POST type, accepts a CSV file which needs to be uploaded to database
- **/getMovieByName/{name}** - GET type, returns a movie by name and corresponding details from the database
- **/getMediaByMediaType/{mediaType}** - GET type, returns all media of type; mediaType
- **/getMediaByRegion/{region}** - GET type, returns all media based on region; region
- **/getTopTenCreatedBy** - GET type, returns top 10 entries filtered based on created_at and sorted in descending order