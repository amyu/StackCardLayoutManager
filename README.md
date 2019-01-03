# StackCardLayoutManager
[![License](https://img.shields.io/hexpm/l/plug.svg)]() [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-StackCardLayoutManager-green.svg?style=flat )]( https://android-arsenal.com/details/1/7358 ) [![Jitpack](https://jitpack.io/v/amyu/StackCardLayoutManager.svg)](https://jitpack.io/#amyu/StackCardLayoutManager)
  
This project is the movement of a new card type UI for Android

## Screenshots  
![](./sc/screen.gif)  
<img src="./sc/capture1.png" width="300">
<img src="./sc/capture2.png" width="300">

## Requirements  
Min Sdk Version : 21  

## How to use
1) Add this to your **build.gradle**.
```groovy
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    implementation 'com.github.amyu:StackCardLayoutManager:1.0'
}
```  

2) Set StackCardLayoutManager in RecyclerView
```kotlin
val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
val maxItemCount = 5
recyclerView.layoutManager = StackCardLayoutManager(maxItemCount)
```

## Credits

StackCardLayoutManager was originally created by [Yuki Mima](https://github.com/amyu)  


## License

    Copyright 2018 amyu.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
