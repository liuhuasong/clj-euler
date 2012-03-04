(ns clj-euler.problems.problem97
  (:use [clojure.contrib.math :only (expt)]))

(def problem97 (mod (inc (* 28433 (expt 2 7830457))) 10000000000 ))