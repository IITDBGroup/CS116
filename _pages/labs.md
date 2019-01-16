---
title: Labs
permalink: labs.html
---

Assignments are due each week before the labs. We will create a git repository for each student  in the course on [bitbucket](http://www.bitbucket.org) which you have to use to submit the assignments. For more information about git see [here]({{ site.baseurl }}/bootstrap.html#learn-how-to-use-git). Please do not delete the `build.xml` file. You should place your code in the `src` folder using the provided package structure. Code for assignment `n` should be placed in package `lecture.labn`, e.g., `lecture.lab3` for assignment `3`.

> We only accept submissions through git!
{: .notice--danger}

{% for lab in site.labs %}
# [{{ lab.title }}]({{ site.baseurl }}{{ lab.url }})

{% assign points = 0 %}
{% for t in lab.tasks %}
{% assign points = points | plus: t.points %}
{% endfor %}

{{ lab.shortdescription }}

**Points: {{ points }}**

{% assign realdue = lab.due | minus: 1 %}
**Due: {{ site.data.labdates[realdue] }}**
{% endfor %}
