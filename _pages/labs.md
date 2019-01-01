---
title: Labs
permalink: labs.html
---

Assignments are due each week before the labs. We will create a git repository for each student  in the course on [bitbucket](http://www.bitbucket.org) which you have to use to submit the assignments. For more information about git see [here]({{ site.baseurl }}/bootstrap.html#learn-how-to-use-git) .

> We only accept submissions through git!
{: .notice--danger}

{% for lab in site.labs %}
# [{{ lab.title }}]({{ site.baseurl }}{{ lab.url }})

{{ lab.shortdescription }}

{% endfor %}
