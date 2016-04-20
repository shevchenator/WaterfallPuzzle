package ru.shevchenko.waterfallpuzzle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.shevchenko.waterfallpuzzle.cutter.CutMap;
import ru.shevchenko.waterfallpuzzle.cutter.ImageCutter;
import ru.shevchenko.waterfallpuzzle.puzzle.PuzzlePiece;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_image)
    ImageView imageView;
    @Bind(R.id.test_image)
    ImageView testImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Bitmap sourceImage = BitmapFactory.decodeResource(getResources(), R.drawable.test_image);
        int horizontalResolution = 8;
        int verticalResolution = 8;
        CutMap cutMap = new CutMap(horizontalResolution, verticalResolution);
        ImageCutter imageCutter = new ImageCutter(sourceImage, cutMap);

        Bitmap orderedBitmap = Bitmap.createBitmap(sourceImage.getWidth(), sourceImage.getHeight(), Bitmap.Config.ARGB_8888);
        drawOrderedPuzzlePieces(imageCutter, cutMap, new Canvas(orderedBitmap));
        testImageView.setImageBitmap(orderedBitmap);

//        drawPuzzleCutOverlay(imageCutter, cutMap);
    }

    private void drawOrderedPuzzlePieces(ImageCutter imageCutter, CutMap cutMap, Canvas canvas) {
        PuzzlePiece[][] puzzlePieces = imageCutter.cutImage();

        for (int i = 0; i < cutMap.getHorizontalResolution(); i++) {
            for (int j = 0; j < cutMap.getVerticalResolution(); j++) {
                PuzzlePiece piece = puzzlePieces[i][j];
                canvas.drawBitmap(piece.getImage(),
                        piece.getAnchorPoint().x - piece.getCenterPoint().x,
                        piece.getAnchorPoint().y - piece.getCenterPoint().y,
                        null);
            }
        }
    }

    private void drawPuzzleCutOverlay(ImageCutter imageCutter) {
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        testImageView.setImageBitmap(imageCutter.drawPuzzleCuttingOverlay(paint));
    }
}
