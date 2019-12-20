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
API Bot needs <b>settings.json</b> to work. It should be located in the same directory as the executable jar.</br>
Otherwise, you must specify the file path through the command line argument.
<pre>
settings.json
{
  "filename": "/results",
  "hostname": "http://localhost:5003",
  "repeat": 1,
  "auth": {
    "type": "Bearer",
    "token": "'token here'"
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

# Parameters
 - <b>filename</b> - The bot result will be written to this file
 - <b>hostname</b> - API service address
 - <b>repeat</b> - Repeat requests chain count
 - (<i>optional</i>) <b>auth</b> - Global authentication method to be written to the header. If it's present, then auth method will be applied to all requests in requests list
   - <b>type</b> - Аuthentication type
   - <b>token</b> - API token
 - <b>requests</b> - List of requests
   - <b>method</b> - Method type
   - <b>url</b> - point address (without hostname)
   - (<i>optional</i>) <b>auth</b> - Local authentication method to be written to the header. If it's present and global <b>auth</b> is also present, then the local method will be applied. If both of these methods are absent, bot will throw an exception
