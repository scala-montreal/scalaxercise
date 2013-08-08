scalaxercise
============

This repository hosts the code for some exercises for Scala-Montreal meet-ups.

Getting started!
----------------

* Clone the repository using git clone.
* Make sure Java 1.6 or higher installed on your machine. If not, install it http://java.com/en/download/help/download_options.xml
* Download and install SBT (simple build tool) from http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html. SBT is a development tool used to compile, run and manage project's dependencies.

Compile and Run
---------------

Go into the project directory and on the command line run

    sbt compile

This will compile this template project.

Run the tests using

    sbt test

Reactive compile/test loop (will recompile and re-run the test every time a source file has changed)

    sbt ~test

Using IDEA
----------------
Any editor can be used, but if you are using IntelliJ IDEA, install the scala plugin (File -> Settings -> plugins)

Then use the sbt plugin to load the project http://blog.jetbrains.com/scala/2013/07/17/sbt-plugin-nightly-builds/

Instructions
------------

In the test sources you will find test cases. Some are completed and serve as examples. Some are marked as 'ignore'. The idea is to put the test active and make it pass one by one.

I suggest starting with the functions package followed by collections, recursive, patternmatching and exceptions.

