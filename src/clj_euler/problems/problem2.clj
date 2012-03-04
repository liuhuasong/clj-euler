(ns clj-euler.problems.problem2
  (:use [clojure.contrib.lazy-seqs :only (fibs) ]))

(def problem2 (reduce + (filter even? (take-while #(< % 4000000) (fibs)))))