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
