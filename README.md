# StackOverFlowUserList
Android App that reads data from endpoint holding stack overflow user data and provides UI for user to see

## Dependencies
- AppCompatActivity
  - I'm a big fan of the material design look and having the toolbar above always seems like an easy win in my book for user experience
- ConstraintLayout
  - I'm fairly new to Android development so I really like utilizing ConstraintLayout because it's the easiest for me to determine where each view will be in relation to the activity's/fragment's other views
  - For this project specifically, using a Linear or Relative Layout would have resulted in nested layouts with different orientations (i.e. the badge count views) which could get messy as we scale
- RecyclerView
  - I really like utilizing Recycler Views as much as possible because of how much we can get out of the box as far as view and view holder efficiency
- Retrofit
  - For network requests and data fetching I like using retrofit because, for me, it's very simple and elegant to use. I know exactly what endpoint I'm hitting and what the path and parameters should be
  - I also like retrofit because of the logging mechanism through OkHTTP which has been very useful as I practice more with retrofit
- Jackson
  - I don't have any preference to Jackson versus Gson, Moshi, etc it was more just something I have used in the past. The one thing I do like is having the annotations because it gives me a way to make sure it's parsing the right way behind the scenes.
- RxJava
  - I am very new to RxJava but it is definitely something I want to get better at using because it is so useful for work that needs to be done off the main thread, like using retrofit to make network requests
- Glide
  - Before I started working, I had no previous experience with image or media loading. I learned about Glide after getting in the industry and how we can utilize the disk and memory caching capabilities.
  
For all of the above dependencies I added, I am still learning as I go so I know that there might be better libraries/solutions we can utilize. I always welcome feedback!
## Notes

1. Included an offline flow if a user tries to enter the app without any network connection. There were no requirements around this so I just added a message to notify the user
