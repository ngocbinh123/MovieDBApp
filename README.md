# MovieDBApp
## Agenda 
- [How to setup project](#How to setup project)
- [Screens](#Screens)
- [Services](#Services)
- [Architecture](#Architecture)
- [Technologies](#Technologies)
- [Demo](#Demo)
## How to setup project
    1. Register account on https://www.themoviedb.org/movie
    2. Get API KEY from your account
    3. [Terminal] Declare API KEY in your environment 
        3.1 open terminal
        3.2 run command `open ~/.zprofile`
        3.3 the `.zprofile` file is opened and add below command file
            export KEY_MOVIE_API="YOUR APK KEY"
    4. save and close file 
    5. Close terminal and open terminal again 
    6. run command to verify KEY_MOVIE_API veriable have value or not
        $KEY_MOVIE_API
    7. [Project] if abobe step is passed, you should clean and rebuild project

## Screens
    1. Landing screen (LandingFragment): show movie list (have load more)
    2. Detail screen (DetailFragment): show detail screen 

## Services
    1. GetMoviesService: to get movies via API 

## Architecture 
    Overview: 
        - clean architecture
        - MVVM 
    Details: 
        - data: 
            - repositories
            - api (response, Api service)
        - domain:
            - usecases
        - presentation:
            - screens (activity, fragment,etc)

## Technologies:
    - Architecture: clean architecture, MVVM 
    - DI: koin
    - API: retrofit
    - others: navigation, jetpack compose, spotless
## Demo
    Please move to `movie_demo` folder to try app and watch demo video
    [movie_demo.mov](movie_demo%2Fmovie_demo.mov)
    