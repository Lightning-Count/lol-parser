# LoL Parser
The League of Legends data aggregation tool, written entirely in Java with the help of GSON for parsing JSON responses from the Riot Games API, and Apache POI for exporting the collected data to an Excel sheet.

## Features
- Search by summoner name to receive a list of matches played
- View match data of the given summoner, such as damage dealt, taken, items bought, etc
- Data collected is exported to a .xls file, saved in the project folder

## Limitations
Currently, the following limitations are in place:

- Can only search by summoner name and in the NA region.
- API limitations mean requests can only be made according to your API Key specifications (20 per second, 100 per 2 mins for a development API key).
- Match data returned is only applicable for the first 20 games returned in the match list.

## How to Use
 - Update the API Key field in main.Main with a valid Riot Games API Key
 - Run the application via JVM, then input a summoner name
 - Data is saved to "new-spreadsheet.xls" in the project folder
