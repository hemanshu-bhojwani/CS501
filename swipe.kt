// Dashboard Swipe Gestures
inner class SwipeListener : GestureDetector.SimpleOnGestureListener() {
        private val SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THRESHOLD = 100

        override fun onFling(
            e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float
        ): Boolean {

            val diffX = e2.x - (e1?.x ?: 0f)
            val diffY = e2.y - (e1?.y ?: 0f)

            // Check if swipe direction is horizontal
            if (kotlin.math.abs(diffX) > kotlin.math.abs(diffY) && kotlin.math.abs(diffX) > SWIPE_THRESHOLD && kotlin.math.abs(
                    velocityX
                ) > SWIPE_VELOCITY_THRESHOLD
            ) {
                // check if swipe is left or right
                if (diffX > 0) {
                    // Swiped right
                    updateDate(-1) // Move to the previous date
                } else {
                    // Swiped left
                    updateDate(1) // Move to the next date
                }
                return true
            }
            return super.onFling(e1, e2, velocityX, velocityY)
        }
    }