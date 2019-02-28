(ns twenty48.core
  (:gen-class))

(def compress-row-left (comp
                        #(concat % (repeat 0))
                        (partial map (partial apply +))
                        (partial mapcat  (partial partition-all 2))
                        (partial partition-by identity)
                        (partial remove zero?)))

(def take-four (partial take 4))
(def move-row-left (comp take-four compress-row-left))
(def move-row-right (comp reverse move-row-left reverse))

(def move-grid-right
  "Moves an entire grid to the right"
  (comp (partial map move-row-right )))

(def move-grid-left
  "Moves an entire grid to the left"
  (comp (partial map move-row-left)))

(defn move-grid-down
  "Moves an entire grid down"
  [grid]
  grid)

(defn move-grid-up
  "Moves an entire grid up"
  [grid]
  grid)
