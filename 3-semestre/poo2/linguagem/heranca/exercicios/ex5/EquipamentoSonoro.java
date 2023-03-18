package heranca.exercicios.ex5;

public class EquipamentoSonoro extends Equipamento {
    private int volume;
    private boolean stereo;

    public EquipamentoSonoro(boolean ligado, int volume, boolean stereo) {
        super(ligado);
        this.volume = volume;
        this.stereo = stereo;
    }

    public void mono() {
        stereo = false;
    }

    public void stereo() {
        stereo = true;
    }

    @Override
    public void liga() {
        super.liga();
        volume = 5;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isStereo() {
        return stereo;
    }

    public void setStereo(boolean stereo) {
        this.stereo = stereo;
    }
}
