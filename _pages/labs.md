---
title: Labs
permalink: labs.html
---

{% for lab in site.labs %}
# [{{ lab.title }}]({{ site.baseurl }}{{ lab.url }})

{{ lab.shortdescription }}

{% endfor %}
