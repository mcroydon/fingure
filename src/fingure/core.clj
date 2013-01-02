(ns fingure.core
	(:gen-class))

(use 'lamina.core 'aleph.tcp 'gloss.core)
(alias 'string 'clojure.string)

(def crlf "\r\n")

(def user-map {"mcroydon" "Matt Croydon\r\nhttp://postneo.com"
	"test" "Test User\r\nhttp://example.com"})

(defn greeting[] (str "Greetings from the fingure finger server." crlf))

(defn respond-user[query] (get user-map query "User not found."))

(defn response [query]
	(println (str "Received a request for " (if (string/blank? query) "index" query) "."))
	(if (string/blank? query)
		(greeting)
		(str (greeting) (respond-user query) crlf)))

(defn handler [ch client-info]
  (receive-all ch
    #(enqueue-and-close ch (response %))))

(defn -main[]
	(start-tcp-server handler {:port 79, :frame (string :utf-8 :delimiters [crlf])}))
