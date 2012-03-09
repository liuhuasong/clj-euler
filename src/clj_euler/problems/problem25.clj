(ns clj-euler.problems.problem25
  (:use [clojure.contrib.lazy-seqs :only (fibs)])
  (:use [clojure.contrib.math :only (expt)]))

(def problem25 (count (take-while #(< % (expt 10 999)) (fibs))))