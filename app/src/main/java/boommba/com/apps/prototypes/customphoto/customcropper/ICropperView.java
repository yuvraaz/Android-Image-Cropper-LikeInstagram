package boommba.com.apps.prototypes.customphoto.customcropper;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;


public interface ICropperView {

    float DEFAULT_MAX_SCALE = 3.0f;
    float DEFAULT_MID_SCALE = 1.75f;
    float DEFAULT_MIN_SCALE = 1.0f;
    int DEFAULT_ZOOM_DURATION = 200;

    /**
     * Returns true if the CropperView is set to allow zooming of Photos.
     *
     * @return true if the CropperView allows zooming.
     */
    boolean canZoom();

    /**
     * Gets the Display Rectangle of the currently displayed Drawable. The Rectangle is relative to
     * this View and includes all scaling and translations.
     *
     * @return - RectF of Displayed Drawable
     */
    RectF getDisplayRect();

    /**
     * Sets the Display Matrix of the currently displayed Drawable. The Rectangle is considered
     * relative to this View and includes all scaling and translations.
     *
     * @param finalMatrix target matrix to set CropperView to
     * @return - true if rectangle was applied successfully
     */
    boolean setDisplayMatrix(Matrix finalMatrix);

    /**
     * Gets the Display Matrix of the currently displayed Drawable. The Rectangle is considered
     * relative to this View and includes all scaling and translations.
     *
     * @return - true if rectangle was applied successfully
     */
    Matrix getDisplayMatrix();

    /**
     * Use {@link #getMinimumScale()} instead, this will be removed in future release
     *
     * @return The current minimum scale level. What this value represents depends on the current
     * {@link ImageView.ScaleType}.
     */
    @Deprecated
    float getMinScale();

    /**
     * Use {@link #setMinimumScale(float minimumScale)} instead, this will be removed in future
     * release
     * <p>&nbsp;</p>
     * Sets the minimum scale level. What this value represents depends on the current {@link
     * ImageView.ScaleType}.
     *
     * @param minScale minimum allowed scale
     */
    @Deprecated
    void setMinScale(float minScale);

    /**
     * @return The current minimum scale level. What this value represents depends on the current
     * {@link ImageView.ScaleType}.
     */
    float getMinimumScale();

    /**
     * Sets the minimum scale level. What this value represents depends on the current {@link
     * ImageView.ScaleType}.
     *
     * @param minimumScale minimum allowed scale
     */
    void setMinimumScale(float minimumScale);

    /**
     * Use {@link #getMediumScale()} instead, this will be removed in future release
     *
     * @return The current middle scale level. What this value represents depends on the current
     * {@link ImageView.ScaleType}.
     */
    @Deprecated
    float getMidScale();

    /**
     * Use {@link #setMediumScale(float mediumScale)} instead, this will be removed in future
     * release
     * <p>&nbsp;</p>
     * Sets the middle scale level. What this value represents depends on the current {@link
     * ImageView.ScaleType}.
     *
     * @param midScale medium scale preset
     */
    @Deprecated
    void setMidScale(float midScale);

    /**
     * @return The current medium scale level. What this value represents depends on the current
     * {@link ImageView.ScaleType}.
     */
    float getMediumScale();

    /*
     * Sets the medium scale level. What this value represents depends on the current {@link android.widget.ImageView.ScaleType}.
     *
     * @param mediumScale medium scale preset
     */
    void setMediumScale(float mediumScale);

    /**
     * Use {@link #getMaximumScale()} instead, this will be removed in future release
     *
     * @return The current maximum scale level. What this value represents depends on the current
     * {@link ImageView.ScaleType}.
     */
    @Deprecated
    float getMaxScale();

    /**
     * Use {@link #setMaximumScale(float maximumScale)} instead, this will be removed in future
     * release
     * <p>&nbsp;</p>
     * Sets the maximum scale level. What this value represents depends on the current {@link
     * ImageView.ScaleType}.
     *
     * @param maxScale maximum allowed scale preset
     */
    @Deprecated
    void setMaxScale(float maxScale);

    /**
     * @return The current maximum scale level. What this value represents depends on the current
     * {@link ImageView.ScaleType}.
     */
    float getMaximumScale();

    /**
     * Sets the maximum scale level. What this value represents depends on the current {@link
     * ImageView.ScaleType}.
     *
     * @param maximumScale maximum allowed scale preset
     */
    void setMaximumScale(float maximumScale);

    /**
     * Returns the current scale value
     *
     * @return float - current scale value
     */
    float getScale();

    /**
     * Changes the current scale to the specified value.
     *
     * @param scale - Value to scale to
     */
    void setScale(float scale);

    /**
     * Return the current scale type in use by the ImageView.
     *
     * @return current ImageView.ScaleType
     */
    ImageView.ScaleType getScaleType();

    /**
     * Controls how the image should be resized or moved to match the size of the ImageView. Any
     * scaling or panning will happen within the confines of this {@link
     * ImageView.ScaleType}.
     *
     * @param scaleType - The desired scaling mode.
     */
    void setScaleType(ImageView.ScaleType scaleType);

    /**
     * Whether to allow the ImageView's parent to intercept the touch event when the photo is scroll
     * to it's horizontal edge.
     *
     * @param allow whether to allow intercepting by parent element or not
     */
    void setAllowParentInterceptOnEdge(boolean allow);

    /**
     * Register a callback to be invoked when the Photo displayed by this view is long-pressed.
     *
     * @param listener - Listener to be registered.
     */
    void setOnLongClickListener(View.OnLongClickListener listener);

    /**
     * Register a callback to be invoked when the Matrix has changed for this View. An example would
     * be the user panning or scaling the Photo.
     *
     * @param listener - Listener to be registered.
     */
    void setOnMatrixChangeListener(CropperViewAttacher.OnMatrixChangedListener listener);

    /**
     * Returns a listener to be invoked when the Photo displayed by this View is tapped with a
     * single tap.
     *
     * @return CropperViewAttacher.OnPhotoTapListener currently set, may be null
     */
    CropperViewAttacher.OnPhotoTapListener getOnPhotoTapListener();

    /**
     * Register a callback to be invoked when the Photo displayed by this View is tapped with a
     * single tap.
     *
     * @param listener - Listener to be registered.
     */
    void setOnPhotoTapListener(CropperViewAttacher.OnPhotoTapListener listener);

    /**
     * Enables rotation via CropperView internal functions.
     *
     * @param rotationDegree - Degree to rotate CropperView to, should be in range 0 to 360
     */
    void setRotationTo(float rotationDegree);

    /**
     * Enables rotation via CropperView internal functions.
     *
     * @param rotationDegree - Degree to rotate CropperView by, should be in range 0 to 360
     */
    void setRotationBy(float rotationDegree);

    /**
     * Returns a callback listener to be invoked when the View is tapped with a single tap.
     *
     * @return CropperViewAttacher.OnViewTapListener currently set, may be null
     */
    CropperViewAttacher.OnViewTapListener getOnViewTapListener();

    /**
     * Register a callback to be invoked when the View is tapped with a single tap.
     *
     * @param listener - Listener to be registered.
     */
    void setOnViewTapListener(CropperViewAttacher.OnViewTapListener listener);

    /**
     * Changes the current scale to the specified value.
     *
     * @param scale   - Value to scale to
     * @param animate - Whether to animate the scale
     */
    void setScale(float scale, boolean animate);

    /**
     * Changes the current scale to the specified value, around the given focal point.
     *
     * @param scale   - Value to scale to
     * @param focalX  - X Focus Point
     * @param focalY  - Y Focus Point
     * @param animate - Whether to animate the scale
     */
    void setScale(float scale, float focalX, float focalY, boolean animate);

    /**
     * Allows you to enable/disable the zoom functionality on the ImageView. When disable the
     * ImageView reverts to using the FIT_CENTER matrix.
     *
     * @param zoomable - Whether the zoom functionality is enabled.
     */
    void setZoomable(boolean zoomable);

    /**
     * Enables rotation via CropperView internal functions. Name is chosen so it won't collide with
     * View.setRotation(float) in API since 11
     *
     * @param rotationDegree - Degree to rotate CropperView to, should be in range 0 to 360
     * @deprecated use {@link #setRotationTo(float)}
     */
    void setPhotoViewRotation(float rotationDegree);

    /**
     * Extracts currently visible area to Bitmap object, if there is no image loaded yet or the
     * ImageView is already destroyed, returns {@code null}
     *
     * @return currently visible area as bitmap or null
     */
    Bitmap getVisibleRectangleBitmap();

    /**
     * Allows to change zoom transition speed, default value is 200 (CropperViewAttacher.DEFAULT_ZOOM_DURATION).
     * Will default to 200 if provided negative value
     *
     * @param milliseconds duration of zoom interpolation
     */
    void setZoomTransitionDuration(int milliseconds);

    /**
     * Will return instance of ICropperView (eg. CropperViewAttacher), can be used to provide better
     * integration
     *
     * @return ICropperView implementation instance if available, null if not
     */
    ICropperView getIPhotoViewImplementation();

    /**
     * Sets custom double tap listener, to intercept default given functions. To reset behavior to
     * default, you can just pass in "null" or public field of CropperViewAttacher.defaultOnDoubleTapListener
     *
     * @param newOnDoubleTapListener custom OnDoubleTapListener to be set on ImageView
     */
    void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener newOnDoubleTapListener);

    void update();
}
