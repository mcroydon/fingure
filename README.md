# Fingure

A hyper-minimal [finger](http://en.wikipedia.org/wiki/Finger_protocol) server written in [Clojure](http://clojure.org/).

Fingure uses [Aleph](http://github.com/ztellman/aleph) for network operations which in turn uses [Netty](http://www.jboss.org/netty) and [Lamina](http://github.com/ztellman/lamina).

## Usage

Fingure uses [Leiningen](http://github.com/technomancy/leiningen) to manage depdencies, build and run.

First grab dependencies and build:

```bash
$ lein deps
$ lein compile
Compiling fingure.core

```

You'll need to run Fingure as the root user since the finger protocol is on port 79.  This may not be a good idea when connected to the public internet.  To run:

```bash
$ sudo lein run -m fingure.core                                                                                                                                                                       
Password:
WARNING: You're currently running as root; probably by accident.
Press control-C to abort or Enter to continue as root.
Set LEIN_ROOT to disable this warning.

#<server$start_server$fn__8925 aleph.netty.server$start_server$fn__8925@94b318>
```

You can now connect to Fingure server using a finger client.  Most OSes (Linux, Mac OS X, Windows) ship with a finger command:

```bash
$ finger mcroydon@localhost
[localhost]
Trying 127.0.0.1...
Greetings from the fingure finger server.
Matt Croydon
http://postneo.com

$ finger test@localhost                                                                                                                                                                                        
[localhost]
Trying 127.0.0.1...
Greetings from the fingure finger server.
Test User
http://example.com

$ finger unknown@localhost
[localhost]
Trying 127.0.0.1...
Greetings from the fingure finger server.
User not found.

```

User information is currently hard-coded in fingure.core/user-map

## Motivation

I've been reading about Clojure off and on for years.  I've recently been intruigued by how [Prismatic](http://getprismatic.com/) uses it and finally took a little time to wrap my head around it.  I've been copying and pasting [Emacs Lisp](http://en.wikipedia.org/wiki/Emacs_Lisp) for even longer, but Lisp syntax has never really stuck with me until now.

Fingure is my attempt at doing something trivial but useful in the language.  Implementing archaic protocols is a bit of a hobby of mine, and an exercise that I often do when learning or evaluating a new language or framework.  I've written [gofinger](http://github.com/mcroydon/gofinger) in go, [phalanges](http://github.com/mcroydon/phalanges) in Scala, [finger.lua](http://gist.github.com/2188358), [nntpd.js](http://gist.github.com/807303) and [finger_server.js](http://gist.github.com/519344).

## License

Copyright © 2012-2013 Matt Croydon

Distributed under the Eclipse Public License, the same as Clojure.  If this license hinders your ability to use Fingure or any of its source code, please get in touch to discuss alternative licensing options.
