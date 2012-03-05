(ns clj-euler.problems.problem25
  (:use [clojure.contrib.lazy-seqs :only (fibs)])
  (:use [clj-euler.math :only (num-digits)]))

(def problem25 (count (take-while #(< (num-digits %) 1000) (fibs))))