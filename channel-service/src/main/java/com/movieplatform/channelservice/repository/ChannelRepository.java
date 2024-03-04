package com.movieplatform.channelservice.repository;

import com.movieplatform.channelservice.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    Optional<Channel> findByName(String name);
}
