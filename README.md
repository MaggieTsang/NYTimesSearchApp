# Project 2 - *NYTimes Search App*

**NYTimes Search App** is an android app that allows a user to search for articles on web using simple filters. The app utilizes [New York Times Search API](http://developer.nytimes.com/docs/read/article_search_api_v2).

Time spent: **30** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **search for news article** by specifying a query and launching a search. Search displays a grid of image results from the New York Times Search API.
* [x] User can **scroll down to see more articles**. The maximum number of articles is limited by the API search.
* [x] User can tap on any image in results to see the full text of article **full-screen**

The following **optional** features are implemented:

* [x] Used the **ActionBar SearchView** or custom layout as the query box
* [x] User can **share an article link** to their friends or email it to themselves
* [x] Improved the user interface and experiment with image assets and/or styling and coloring
* [x] Replace Picasso with [Glide](http://inthecheesefactory.com/blog/get-to-know-glide-recommended-by-google/en) for more efficient image rendering.

The following **additional** features are implemented:

* [x] Inserts a 'loading' gif in replacement of an image that does not load 

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://g.recordit.co/mfNW769geN.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [Recordit](http://recordit.co/).

<img src='http://g.recordit.co/h2jNQijXdn.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [Recordit](http://recordit.co/).

## Notes

- Attempted to implement filters feature. Had trouble doing so when encountered with DatePickerFragment for the calender display. Files are attached, but not functional.
- Attempted to use RecyclerView in order to display the grid in a skewed manner. Made a new file ArticleAdapter to do so, but was unsuccesful in constructing it for a GridView.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android
- [Glide](https://github.com/bumptech/glide) - Loads gif for Android

## License

    Copyright [2016] [Maggie Tsang]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
