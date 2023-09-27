Adapter pattern
Works as a bridge between two incompatible interfaces. 
A structural pattern - combines the capability of two independent interfaces.

A single class is responsible to join functionalities of independent or incompatible interfaces. 
Real life example - card reader that acts as an adapter between memory card and a laptop. 
You plugin the memory card into card reader and card reader into the laptop so that memory card can be read via laptop.

This example 
An audio player device can play mp3 files only and wants to use an advanced audio player capable of playing vlc and mp4 files.

Implementation
We have a MediaPlayer interface
A concrete class AudioPlayer implementing the MediaPlayer interface. 
AudioPlayer can play mp3 format audio files by default.
We have another interface AdvancedMediaPlayer and 
concrete classes implementing the AdvancedMediaPlayer interface. 
These classes can play vlc and mp4 format files.

We want to make AudioPlayer to play other formats as well. 
To attain this, we have created an adapter class MediaAdapter which implements the MediaPlayer interface and 
uses AdvancedMediaPlayer objects to play the required format.

AudioPlayer uses the adapter class MediaAdapter passing it the desired audio type without knowing the actual class 
which can play the desired format. 
AdapterPatternDemo, - demo class will use AudioPlayer class to play various formats.

Step 1
Create interfaces for Media Player and Advanced Media Player.
MediaPlayer.java
AdvancedMediaPlayer.java

Step 2
Create concrete classes implementing the AdvancedMediaPlayer interface.
VlcPlayer.java
Mp4Player.java

Step 3
Create adapter class implementing the MediaPlayer interface.
MediaAdapter.java

Step 4
Create concrete class implementing the MediaPlayer interface.
AudioPlayer.java

Step 5
Use the AudioPlayer to play different types of audio formats.
AdapterPatternDemo.java