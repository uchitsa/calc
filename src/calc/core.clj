(ns calc.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn read-expr []
  (println "Enter the expression (like: 2 + 2 * 2):")
  (read-line))

(defn calc [expr]
  (try
    (eval (read-string expr))
    (catch Exception e
      (println "Wrong expression. Try again."))))

(defn -main []
  (println "Simple calc. Enter 'quit' to exit.")
  (loop []
    (let [expr (read-expr)]
      (if (= "quit" (str/lower-case expr))
        (do (println "Bye bye!")
          (System/exit 0))
        (do (println "Result is: " (calc expr))
          (recur))))))
