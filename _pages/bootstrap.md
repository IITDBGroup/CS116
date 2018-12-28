---
title: Getting Started
permalink: bootstrap.html
---

## First Steps

### Install the Java Development Environment

You can get **OpenJDK** from [https://jdk.java.net/11/](https://jdk.java.net/11/). Nowaways there are only tiny difference between **OpenJDK** and **Oracle JDK** so which one you install should not matter for the most part.

### Learn how to use Java's toolchain

The Java Development Toolkit (JDK) contains several binaries that are used to run compiled Java bytecode, to compile code, to create `jar` archives, a shell for interpreted execution, and several others. The first step when using Java will be to familiarize yourself with the use of these binaries. The most important ones for are now are `javac` the compiler that generates `.class` files storing java byte code and `java` that starts a Java Virtual Machine to execute code. Below is a very basic example:

{% asciicast 218690 %}

`javac` takes a list of sources files (`.java`) and compiles them into a list of class files (`.class`) that contain java bytecode. Run `javac -help` to see a list of available options. `javac` is used like this:

~~~shell
javac [-cp <class_path>] [-d <binary_dir>] <source_files>
~~~

Here `<source_files>` is a list of `.java` files you want to compile, `<class_path>` is a list (elements are separated by `:`) of directories and jar files that contain user-defined classes that are used by the sources files you want to compile, and `<binary_dir>` is the directory where the generated class files will be stored.

The `java` command is used to start a JVM and execute code. It is called like this:

~~~shell
java [-cp <class_path>] <class_name>
~~~

Here `<class_path>` is a class path as above and `<class_name>` is the fully qualified (including the package) name of the class which contains the `main` method you want to run.

If the class we want to execute is stored in a jar file, then you can either add the jar file to the class path or use the `-jar` option. Any parameters passed after `<class_name>` will be passed as a `String[]` to the `main` method.

Since Java versions 9


### Learn how to use an IDE and/or Programmers Texteditor

Using the right tools will greatly enhance your programming experience. You want to setup a and learn how to use a good Java IDE and/or programmers text editor. Also see [here](https://xkcd.com/378/). Following is a (highly biased) selection of IDEs and Editors you may want to check out:

#### IDEs

* **Eclipse**: One of the best Java IDEs (also support for many other languages can be added): [https://www.eclipse.org/downloads/](https://www.eclipse.org/downloads/)
* **NetBeans**: Has been open sourced, but not all functionality available for newer Java versions yet. Otherwise, a great IDE: [https://netbeans.org/](https://netbeans.org/)
* Or if you prefer cloud IDEs **CodeEnvy**: [https://codenvy.io/](https://codenvy.io/)

#### Editors

* **Emacs**: slow learning curve, but extremly powerful and extensible if you do not mind the odd keyboard shortcuts: [https://www.gnu.org/software/emacs/](https://www.gnu.org/software/emacs/)
* **Vi**: very fast, low resource consumption, extremly powerful and extensible: [https://www.vim.org/](https://www.vim.org/)
* **Atom**: [https://atom.io/](https://atom.io/)
* **Visual Studio code**: [https://code.visualstudio.com/](https://code.visualstudio.com/)


### Learn how to use git ###


### Use the excellent Java documentation

Java provides quite a lot of functionality out of the box. It is easy to get overwhelmed. Finding out what classes exist and what interface they provide is easy using Java's online documentation: [https://docs.oracle.com/en/java/javase/11/docs/api/java.base/module-summary.html](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/module-summary.html)


## Next Steps

### Learn about debugging

### Learn about testing


### Learn how to use the shell


## Outlook

### Learn about build tools

* Ant
* Maven
* Gradle

### Learn about Virtualization

### Learn about DevOps
