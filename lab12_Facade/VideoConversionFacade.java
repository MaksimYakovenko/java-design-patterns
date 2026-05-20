/**
 * Фасад для конвертації відеофайлів.
 * Приховує складну взаємодію між кодеками, зчитувачем бітрейту та аудіомікшером.
 */
public class VideoConversionFacade {

    /**
     * Конвертує відеофайл у заданий формат.
     *
     * @param file  вихідний відеофайл
     * @param codec цільовий кодек (формат)
     * @return сконвертований відеофайл
     */
    public VideoFile convert(VideoFile file, Codec codec) {
        System.out.println("======= VideoConversionFacade: conversion started. =======");

        Codec sourceCodec = CodecFactory.extract(file);
        Buffer buffer = BitrateReader.read(file, sourceCodec);
        VideoFile result = BitrateReader.convert(buffer, file.getName(), codec);

        AudioMixer audioMixer = new AudioMixer();
        audioMixer.fix(result, file.getAudioBuffer());

        System.out.println("====== VideoConversionFacade: conversion completed =======");
        return result;
    }
}

