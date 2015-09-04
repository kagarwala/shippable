-Used Spring MVC based app

-For repo issue used githubapi - https://developer.github.com/v3/issues/#list-issues-for-a-repository

- For Ui used bbotstrap and for rest client used spring resttemplate.

- The solution gives issues opened (might be reopened/created) within 24 hours/1week timeframes. NOT in a calender day/week.

- Used github apis "updated_at" attribute


Explanation:-
It seems github api doesn't expose any statistic api for issue, so we will need to use the detailed list of repo issues api and traverse to build the data.
We only need updated_at attribute for each issue as the question asks opened within 24 hours.

Improvement:-

- Need more corner case handling
-As every request, involves many calls to github Api and if we need this info on regular basis, then we can build a git repo issue metadata in our own datastore. Say, we keep updating our issue metadata db for each call, so next time we get a new call we only get the delta from github.


