<pre> 
                  `hy`
                 `hmmh.
                `hmmmmd-
               `hmmmmmmm-
              `hmmmmmmmmm-
             `hmmmmmmmmmmm-
             hmmmmmmmmmmmmd.
            smmmmmmmmmmmmmmd`
           +mmmmdhhhhhddmmmmh`
          :mmmmo`  yhhhhhhmmms
         .mmmmhyooyhhhhhhhhmdm+
        `hs.smhhhhhhhhhhhhhm/:m:               \       _ \   _ _|         __ )            |
       -yh  `hmhhhhhhhhhhdmy  smd/            _ \     |   |    |          __ \     _ \    __|
    -/ymm.    /hmdddddddmy:   `mmh+/.        ___ \    ___/     |          |   |   (   |   |
 -oo- -m+       `:/+++/-`      +m.  /s-    _/    _\  _|      ___|        ____/   \___/   \__|
hs    sh                       `m/   `ds
-d+  `m:                        od `-hy.
 `mmdhd                         .mymms
  ommm+                          hmmms
:+hmmm`                          ommmm+-
:shdmy                           +mmmmy:
    ho      `:oyyyyssyyyo/.      sh-/.
    oh` `-+yy/.         ./sh+`  .m/
     +yyy+:`               `+hyyh/

</pre>
# API-Bot
Bot for testing API

# Usage
API Bot needs settings.json to work. It should be located in the same directory as the executable jar.</br>
Otherwise, you must specify the file path through the command line argument.
<pre>
settings.json
{
  "filename": "/results",
  "hostname": "http://localhost:5003",
  "repeat": 1,
  "auth": {
    "type": "Bearer",
    "token": "<token here>"
  },
  "requests": [
    {
      "method": "GET",
      "url": "/some/point",
      "auth": {
        "type": "none"
      }
    },
    {
      "method": "GET",
      "url": "/some/points"
    },
    {
      "method": "GET",
      "url": "/some/point/?with=arg1"
    },
    {
      "method": "GET",
      "url": "/some/point/?with=arg2"
    },
    {
      "method": "GET",
      "url": "/some/point/?with=arg1,arg2"
    },
    {
      "method": "GET",
      "url": "/some/point/?with=arg2,arg1"
    },
    {
      "method": "GET",
      "url": "/another/point"
    }
  ]
}
</pre>
