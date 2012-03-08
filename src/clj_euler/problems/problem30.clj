(ns clj-euler.problems.problem30
  (:use [clojure.contrib.math :only (expt)])
  (:use [clj-euler.math :only (digits)]))

(defn equals-n-powered [x n] (= x (reduce + (map #(expt % n) (digits x)))))

(def problem30 
  (reduce + (rest (filter 
     #(equals-n-powered % 5)
     ;9^5 * 7 is only a 6-digit number, so we don't need to look beyond that limit
     (range 1 1000000)))))