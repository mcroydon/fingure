(ns fingure.core
	(:gen-class))

(use 'lamina.core 'aleph.tcp 'gloss.core)
(alias 'string 'clojure.string)

(defn crlf[] "\r\n")

(defn greeting[] (str "Greetings from the fingure finger server." (crlf)))

(defn response [query]
	(println (str "Received a request for " (if (string/blank? query) "index" query) "."))
	(if (string/blank? query)
		(greeting)
		(str (greeting) "No information about " query " found." (crlf))))

(defn handler [ch client-info]
  (receive-all ch
    #(enqueue-and-close ch (response %))))

(defn -main[]
	(start-tcp-server handler {:port 79, :frame (string :utf-8 :delimiters [(crlf)])}))
