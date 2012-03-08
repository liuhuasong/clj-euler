(ns clj-euler.problems.problem34
  (:use [clj-euler.math :only (fac digits)]))

(defn equals-factorialized [x] (= x (reduce + (map fac (digits x)))))

(def problem34 
  (reduce + (drop 2
		(filter equals-factorialized
		;9! * 8 is a 7 digit number, so stop there
		(range 1 3000000)))))