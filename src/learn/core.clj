(ns learn.core
  (:gen-class))

(defn messenger-builder [greeting]
  (fn [who] (println greeting who)))

(def hello-er (messenger-builder "Hello"))

(hello-er "world!")

;; Test your knowledge
(def greet (fn [] (println "Hello")))

#(println "Hello")

(defn greeting
  ([] "Hello, World!")
  ([x] (str "Hello" ", " x "!"))
  ([x y] (str x ", " y "!")))

;; For testing
(assert (= "Hello, World!" (greeting)))
(assert (= "Hello, Clojure!" (greeting "Clojure")))
(assert (= "Good morning, Clojure!" (greeting "Good morning" "Clojure")))

(defn do-nothing [x] x)

(source identity)

(defn always-thing [x & rest] :thing)

(defn make-thingy [x & rest] (fn [& args] x))

;; Tests
(let [n (rand-int Integer/MAX_VALUE)
      f (make-thingy n)]
  (assert (= n (f)))
  (assert (= n (f :foo)))
  (assert (= n (apply f :foo (range)))))

(defn triplicate [f] (do (f)(f)(f)))
(triplicate (fn [] (println "Hello")))

(defn opposite [f]
          (fn [& args]
            (not (apply f args))))

(defn triplicate2 [f & args]
  (triplicate (fn []
                (apply f args))))

(triplicate2 println "hello")

(assert (= -1.0 (Math/cos Math/PI)))
(defn sin-plus-consine [x] (+ (Math/pow (Math/sin x) 2)
                              (Math/pow (Math/cos x) 2)))

(assert (= 1.0 (sin-plus-consine 2)))

;; 11) Define a function that takes an HTTP URL as a string,
;; fetches that URL from the web, and returns the content
;; as a string.

;; Hint: Using the java.net.URL class and its openStream method.
;; Then use the Clojure slurp function to get the content
;; as a string.

;; (defn http-get [url]
;;   (slurp (.openStream (java.net.URL. url))))

(defn http-get [url]
  (slurp url))

(assert (.contains (http-get "http://www.w3.org") "html")

(defn one-less-arg [f x]
  (fn [& args] (apply f x args)))

;; ((one-less-arg + 1) 1 2 3)
(defn two-fns [f g]
  (fn [x]
    (println x)
    (f (g x))))

;; (def times-two (fn [x] (* x 2)))
;; (def times-four (fn [x] (* x 4)))
;; ((two-fns times-two times-four) 3) ;; => 24
