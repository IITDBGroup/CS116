---
title: Course Materials
permalink: materials.html
---

# Notebooks

## The Java language

These notebooks teach you basic Java. Use them for self study and to recap what you have learned in class. The notebooks will also be used and updated during class.

{% assign javanbs = site.data.notebooks | where: "type", "java" %}

{% for nb in javanbs %}
* [{{ nb.description }}]({{ site.baseurl }}/notebooks/{{ nb.filename }}.ipynb.html)
{% endfor %}

## Java build-in packages and popular third party packages

These notebooks teach you some important packages that are part of the core Java language or popular third-party packages.

{% assign libsnbs = site.data.notebooks | where: "type", "libs" %}

{% for nb in libsnbs %}
* [{{ nb.description }}]({{ site.baseurl }}/notebooks/{{ nb.filename }}.ipynb.html)
{% endfor %}
