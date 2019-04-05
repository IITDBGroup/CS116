---
title: Project
permalink: /project.html
classes: wide
---

# Overview

For the project you will design a contact management system.

The project consists of a design part and an implementation part. The design part is due on {{ site.data.course.due.project_design }} and an implementation part that is due {{ site.data.course.due.project_implementation }}.
Use one of the group members repositories for collaboration and submission of the code [bitbucket](http://www.bitbucket.org). For more information about git see [here]({{ site.baseurl }}/bootstrap.html#learn-how-to-use-git).

# Administrative Information

## Groups

The projects are done in groups of 3 students. Please form groups until {{ site.data.course.due.project_groups }}.

> Groups will be 3 students each.
{: .notice--info }

## Due Dates

* **form groups**: {{ site.data.course.due.project_groups }}
* **design due date**: {{ site.data.course.due.project_design }}
* **final project due date**: {{ site.data.course.due.project_implementation }}

## Project Submission

Deliverables are submitted through git. Please inform the TAs and the instructor about which of the group member's repositories you will use.

> We only accept submissions through git!
{: .notice--danger}

## Deliverables

- **object-oriented design of a model for contact information** - this should be submitted by {{ site.data.course.due.project_design }}
- **implementation in Java** - this should be submitted by {{ site.data.course.due.project_implementation }}

# Project Requirements

For the project you will design a **contact management system**. This entails:

1. **design and implement classes for storing contact information such as name, address, email and phone numbers**
  - first identify what information you want to model for contacts
  - then determine how this can be modeled as classes
  - keep in mind that not all possible information will be available for every contact
  - write data classes that store such information
2. **implement a class that stores and manages all contacts (a set of contacts)**
  - this class should allow addresses to be added, deleted, and searched for
  - use this class to encapsulate handling of contacts
  - searching is the most open-ended part here. At least you should support searching by name matching on substrings, e.g., searching for `Pet` would return all contacts where their name includes the string `Pet`
3. **implement support for writing contacts to a file and for reading contacts from a file**
  - note that if you want to you can reuse your CSV file management from [lab 4]({{ site.baseurl }}/labs/lab4.html)
4. **write a command-line or GUI application that allows adding / deleting / and searching contacts**

> It may be useful to process 1-3 in sequence since they rely on each other.
{: .notice--info }
