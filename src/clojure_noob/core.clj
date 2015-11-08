(ns clojure-noob.core
  (:gen-class))

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])


(defn needs-matching-part?
  [part]
  (re-find #"^left-" (:name part)))

(defn make-matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  [asym-parts]
  (reduce (fn [result part]
            (let [result (conj result part)]
              (if (needs-matching-part? part)
                (conj result (make-matching-part part))
                result)))
          []
          asym-parts))

(defn hit
  [asym-parts]
  (let [sym-parts (symmetrize-body-parts asym-parts)
        total (reduce + 0 (map :size sym-parts))
        rand-target (inc (rand total))]
    (loop [[part & rest] sym-parts
           accum-sum (:size part)]
      (if (> accum-sum rand-target)
        part
        (recur rest (+ accum-sum (:size part)))))))

Excerpt From: Daniel Higginbotham. “Clojure for the Brave and True.” iBooks. 
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World! Clojure yet again"))





